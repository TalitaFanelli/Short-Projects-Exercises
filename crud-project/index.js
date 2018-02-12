const express = require('express')
const path = require('path')
const app = express()
const port = process.env.PORT || 3000
const mysql = require('mysql')
const bodyParser = require('body-parser')

const connection = mysql.createConnection({
    host: '127.0.0.1',
    user: 'root',
    password: '',
    database: 'register'
})

const dependencies = {
    connection
}

const people = require('./routes/people')

app.use(bodyParser.urlencoded({extended: false}))

app.use(express.static('public'))

app.get('/', (req, res) => {
    res.render('home')
})

app.use('/people', people(dependencies))

app.set('views', path.join(__dirname, 'views'))
app.set('view engine', 'ejs')

connection.connect(err => {
    if(err){
        console.log('Erro ao conectar no banco: ' + err)
    }
    else{
        app.listen(port, () => {
            console.log('database connected and server listening on port ' + port)
        })
    }
})



