//Router Properties
const express = require('express')
const router = express.Router()

//Importing Model
const News = require('../models/news')

router.use((req, res, next) => {
    if ('user' in req.session) {
        if (req.session.user.roles.indexOf('admin') >= 0) {
            return next()
        }
        else {
            res.redirect('/')
        }
    }
    else{
    //res.send('Please, sign on')
    res.redirect('/login')
    }
})

//Rendering pages to index
router.get('/', (req, res) => {
    res.send('admin')
})

router.get('/news', async (req, res) => {
    const news = await News.find({})
    res.render('news/admin', { news })
})

module.exports = router