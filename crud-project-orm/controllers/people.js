const index = async ({ People }, req, res) => {
    const people = await People.findAll()
    res.render('people/index', { people })
}

const createForm = (req, res) => {
    res.render('people/create')
}

const createProcess = async ({ People }, req, res) => {
    await People.create(req.body)
    res.redirect('/people')
}

const deleteOne = async ({ People }, req, res) => {
    await People.destroy({
        where: {
            id: req.params.id
        }
    })
    res.redirect('/people')
}

const updateForm = async({ People }, req, res) => {
    const person = await People.findById(req.params.id)
    res.render('people/update', {person})
}

const updateProcess = async ({ People }, req, res) => {
    await People.update(req.body, {
        where:{
            id: req.params.id
        }
    })
    res.redirect('/people')
}

module.exports = {
    index,
    createForm,
    createProcess,
    deleteOne,
    updateForm,
    updateProcess
}