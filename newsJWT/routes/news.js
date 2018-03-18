//Router Properties
const express = require('express')
const router = express.Router()

//Importing Model
const News = require('../models/news')

//Rendering pages to index
router.get('/', async (req, res) => {

    /*let conditions = {}

    if(!('user' in req.session)){
        conditions = { category: 'public' }
    }*/

    const conditions = { category: 'public' }

    const news = await News.find(conditions)
    //const news = await News.find({ category: 'public' })
    res.render('news/index', { news })
})

module.exports = router