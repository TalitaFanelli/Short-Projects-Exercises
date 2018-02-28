//BD Properties
const mongoose = require('mongoose')

//Schema Definition
const showSchema = mongoose.Schema({
    name: {
        type: String,
        required: true
    },
    status:{
        type: String,
        enumValues: ['to-watch', 'watching', 'watched']
    },
    comments: [String]
})

//Creating collection Shows with its schema into MongoDB
const Show = mongoose.model('Shows', showSchema)

module.exports = Show