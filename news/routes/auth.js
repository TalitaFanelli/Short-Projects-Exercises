//Router Properties
const express = require('express')
const router = express.Router()

//Importing Models
const User = require('../models/user')

router.use((req, res, next) => {
    if ('user' in req.session) {
        res.locals.user = req.session.user
        res.locals.roles = req.session.roles
    }

    next()
})

router.get('/change-role/:role', (req, res) => {
    if ('user' in req.session) {
        if (req.session.user.roles.indexOf(req.params.role) >= 0) {
            req.session.roles = req.params.role
        }

        res.redirect('/')
    } else {
        res.redirect('/login')
    }
})

//Render Login Page
router.get('/login', (req, res) => {
    res.render('login')
})

router.get('/logout', (req, res) => {

    req.session.destroy(() => {
        res.redirect('/')
    })
})

//Validate user's credentials
router.post('/login', async (req, res) => {
    const user = await User.findOne({
        username: req.body.username
    })

    if (user) {
        const isValid = await user.checkPassword(req.body.password)

        if (isValid) {
            req.session.user = user
            req.session.roles = user.roles[0]
            res.redirect('/')
        } else {
            res.redirect('/login')
        }
        //res.send({user, isValid})
    } else {
        res.redirect('/login')
    }
})

module.exports = router
