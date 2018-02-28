//Server Properties
const express = require('express')
const app = express()
const port = process.env.PORT || 3000

//BD Properties
const url = 'mongodb://localhost/my-tvshows'
const mongodb =  process.env.MONGODB || url
const mongoose = require('mongoose')
mongoose.Promise = global.Promise

//Process request body
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended: true}))

//Import views + setting view engine
const path = require('path')
app.set('views', path.join(__dirname, 'views'))
app.set('view engine','ejs')

//Defining Assets
app.use(express.static('public'))

//Request render pages to routes
const pages = require('./routes/pages')
app.use('/', pages)

const shows = require('./routes/tv-shows')
app.use('/tv-shows', shows)

//BD connection + starting server
mongoose
        .connect(mongodb) //{useMongoClient: true}
        .then(() => {
            app.listen(port, () => {
                console.log('Listening on port ' + port)
            })
        })
        .catch((err) => {
            console.log(err)
        })
