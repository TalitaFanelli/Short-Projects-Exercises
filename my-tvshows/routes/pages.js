//Router Properties
const express = require('express')
const pagesController = require('../controllers/pages')
const router = express.Router()

//Request render pages to controllers
router.get('/', pagesController.index)
router.get('/about', pagesController.about)

module.exports = router