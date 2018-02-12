const express = require('express')
const peopleController = require('../controller/people')

    const peopleRouter = ({ connection }) => { 

    const router = express.Router()
    
    router.get('/', peopleController.index.bind(null, connection))

    router.get('/delete/:id', peopleController.indexDelete.bind(null, connection))

    router.get('/create', peopleController.createForm)

    router.post('/create', peopleController.createProcess.bind(null, connection)) 

    router.get('/update/:id', peopleController.updateForm.bind(null, connection))
    router.post('/update/:id', peopleController.updateProcess.bind(null, connection))

    return router
}

module.exports = peopleRouter