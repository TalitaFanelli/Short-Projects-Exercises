const express = require('express')
const peopleController = require('../controllers/people.js')
const router = express.Router()
const model = require('../models/index')

router.get('/', peopleController.index.bind(null, model.models))
router.get('/create', peopleController.createForm)
router.post('/create', peopleController.createProcess.bind(null, model.models))
router.get('/delete/:id', peopleController.deleteOne.bind(null, model.models))
router.get('/update/:id', peopleController.updateForm.bind(null, model.models))
router.post('/update/:id', peopleController.updateProcess.bind(null, model.models))

module.exports = router