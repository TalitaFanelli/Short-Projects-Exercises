//Check which is the TV Show status
const labels = [
    {id: 'to-watch'},
    {id: 'watching'},
    {id: 'watched'}
]

//Setting pagination 
const pagination = async(model, conditions, params) => {
    
    const total = await model.count(conditions)  
    const pageSize = parseInt(params.pageSize) || 20
    const currentPage = parseInt(params.page) || 0

    const pagination = {
        currentPage: currentPage,
        pageSize: pageSize,
        pages: parseInt(total / pageSize)
    }

    const results = await model.find(conditions)  
                                .skip(currentPage*pageSize)  
                                .limit(pageSize)  
    return {
        data: results,
        pagination
    }
}

//Render TV Show's Index Page
const index = async({Show}, req, res) => {
   // const docs = await Show.find({})
   const results = await pagination(Show, {}, req.query)
    res.render('tv-shows/index', {results, labels})
}

//Save one new TV Show
const newProcess = async({Show}, req, res) => {

    const show = new Show(req.body)

    try{
        await show.save()
        res.redirect('/tv-shows')
    }
    catch(e){
        //console.log(e.errors)
        //console.log(Object.keys(e.errors)) //Show which field has an error
     
        res.render('tv-shows/new', { errors: Object.keys(e.errors) })
    }
}
    
//Render a form for a new TV Show
const newForm = (req, res) => {
    res.render('tv-shows/new', { errors: [] } )
}

//Delete one TV Show by id
const deleteProcess = async({Show}, req, res) => {

    await Show.remove({ _id: req.params.id })
    res.redirect('/tv-shows')
}

//Update one TV Show
const updateProcess = async({Show}, req, res) => {

    const show = await Show.findOne( { _id: req.params.id } )
    
    show.name = req.body.name
    show.status = req.body.status

    try{
        await show.save()
        res.redirect('/tv-shows')
    }
    catch(e){
        res.render('tv-shows/update', { show, labels, errors: Object.keys(e.errors) })
    }
}

//Render a form with one TV Show
const updateForm = async({Show}, req, res) => {

    const show = await Show.findOne( {_id: req.params.id} )
    res.render('tv-shows/update', { show, labels, errors: [] })
}

//Render details about selected TV Show
const info = async({Show}, req, res) => {
    
    const show = await Show.findOne({_id: req.params.id}) 
    res.render('tv-shows/info', { show })
}

const addComment = async({Show}, req, res) => {

    await Show.updateOne({ _id: req.params.id}, { $push: {comments: req.body.commentary} })
    res.redirect('/tv-shows/info/' + req.params.id)
}

module.exports = {
    index,
    newProcess,
    newForm,
    deleteProcess,
    updateProcess,
    updateForm,
    info,
    addComment
}