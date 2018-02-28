//Router Properties
const express = require('express')
const showsController = require('../controllers/tv-shows')
const router = express.Router()

//Require Model
const Show = require('../models/tv-shows')
const models = {
    Show
}

//Request render pages to controllers
router.get('/', showsController.index.bind(null, models))
router.get('/new', showsController.newForm)
router.post('/new', showsController.newProcess.bind(null, models))
router.get('/delete/:id', showsController.deleteProcess.bind(null, models))
router.get('/update/:id', showsController.updateForm.bind(null, models))
router.post('/update/:id', showsController.updateProcess.bind(null, models))
router.get('/info/:id', showsController.info.bind(null, models))
router.post('/info/:id', showsController.addComment.bind(null, models))

module.exports = router