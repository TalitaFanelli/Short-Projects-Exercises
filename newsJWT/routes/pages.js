//Router Properties
const express = require('express')
const router = express.Router()

//Importing Model
const News = require('../models/news')

//Rendering pages to index
router.get('/', (req, res) => {
    res.render('index')
})

module.exports = router