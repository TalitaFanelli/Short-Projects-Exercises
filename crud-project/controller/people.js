
const peopleModel = require('../models/people')

const index = async(connection, req, res) => {
    const results = await peopleModel.findAll(connection)
    res.render('people/index', {peopleModel: results})
}

const indexDelete = async(connection, req, res) => {
    await peopleModel.deletePerson(connection, req.params.id)
    res.redirect('/people')
}

const createForm = (req, res) => {
    res.render('people/create')
}

const createProcess = async(connection, req, res) => {
   await peopleModel.createPerson(connection, req.body)
   res.redirect('/people')
}

const updateForm = async(connection, req, res) => {
    const person = await peopleModel.findById(connection, req.params.id)
    res.render('people/update', { person })
}

const updateProcess = async(connection, req, res) => {
   await peopleModel.updatePerson(connection, req.params.id, req.body)
   res.redirect('/people')
}

module.exports = {
    index,
    indexDelete,
    createForm,
    createProcess,
    updateForm,
    updateProcess
} 
