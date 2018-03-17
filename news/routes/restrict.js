//Router Properties
const express = require('express')
const router = express.Router()

//Importing Model
const News = require('../models/news')

router.use((req, res, next) => {
    //console.log('opa')
    if ('user' in req.session) {
        if (req.session.user.roles.indexOf('user') >= 0) {
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
    res.send('restrict access')
})

router.get('/news', async (req, res) => {
    const news = await News.find({ category: 'restrict' })
    res.render('news/restrict', { news })
})

module.exports = router