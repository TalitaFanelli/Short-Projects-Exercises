const express = require('express')
const path = require('path')
const app = express()
const port = process.env.PORT || 3000

const model = require('./models/index.js')
const people = require('./routes/people.js')

const bodyParser = require('body-parser')

app.use(bodyParser.urlencoded({extended: true}))
app.use(express.static('public'))

app.get('/', (req, res) => {
    res.render('index')
})
app.use('/people', people)

app.set('views', path.join(__dirname, 'views'))
app.set('view engine', 'ejs')

model.sequelize.sync().then(() => {
    console.log('DB connected')

    app.listen(port , () => {
        console.log('Listening port = ' + port)
    })
})
