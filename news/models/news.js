//BD Properties
const mongoose = require('mongoose')

//Schema Definition
const newsSchema = new mongoose.Schema({
    title: String,
    content: String,
    category: String
})

//Creating collection News with its schema into MongoDB
const News = mongoose.model('News', newsSchema)

module.exports = News