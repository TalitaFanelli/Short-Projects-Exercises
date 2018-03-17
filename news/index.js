//Server Properties
const express = require('express')
const app = express()
const port = process.env.PORT || 3000

//BD Properties
const url = 'mongodb://localhost/news'
const mongodb = process.env.MONGODB || url
const mongoose = require('mongoose')
mongoose.Promise = global.Promise

//Import views + setting view engine
const path = require('path')
app.set('views', path.join(__dirname, 'views'))
app.set('view engine', 'ejs')

//Defining Assets
app.use(express.static('public'))

//Importing session
const session = require('express-session') //Tem que instalar o express-session com o NPM para poder utilizá-lo
app.use(session({ secret: 'fullstack-master', resave: true, saveUninitialized: true })) //é uma chave para escrever valores no cookie
//resave and saveUninitialized são parâmetros obrigatórios. True é default, se quiser colocar false precisa consultar o manual

//Importing body-parser
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({ extended: true }))


//Request render pages to routes

const auth = require('./routes/auth')
app.use('/', auth)

const pages = require('./routes/pages.js')
app.use('/', pages)

const news = require('./routes/news')
app.use('/news', news)

const restrict = require('./routes/restrict')
app.use('/restrict', restrict)

const admin = require('./routes/admin')
app.use('/admin', admin)

//Creating initial user
const User = require('./models/user')

const createInitialUser = (async () => {
    const total = await User.count({ })

    if (total === 0) {

        const user = new User({
            username: 'adm',
            password: 'adm',
            roles: ['admin', 'user']
        })

        await user.save(() => {
            console.log('user created')
        })

        const user2 = new User({
            username: 'user',
            password: 'user',
            roles: ['user']
        })

        await user2.save()

        const user3 = new User({
            username: 'talita',
            password: 'talita',
            roles: ['admin']
        })

        await user3.save()
    }
    else {
        console.log('skipped user creation')
    }

    //Creating news
    const News = require('./models/news')

    const createPublicNews = new News({
        title: 'Public News ' + new Date().getTime(),
        content: 'content',
        category: 'public'
    })

    await createPublicNews.save()

    const createRestrictNews = new News({
        title: 'Restrict News ' + new Date().getTime(),
        content: 'content',
        category: 'restrict'
    })

    await createRestrictNews.save()
})


//BD connection + starting server
mongoose
    .connect(mongodb) //{
    .then(() => {

        createInitialUser()

        app.listen(port, () => {
            console.log('listening port = ' + port)
        })
    })
    .catch(err => {
        console.log(err)
    })

//Create first user
/*
const User = require('./models/user')
User
    .count({
        username: 'Talita'
    })
    .then(total => {
        //console.log(total)
        if(total === 0){
            
            const user = new User({
                username: 'Talita',
                password: 'talita92'
            })
            
            user.save(() => {
                console.log('user created')
            })
        }
    })
/*

/*
const User = require('./models/user')
const user = new User({
    username: 'Talita',
    password: 'talita92'
})

user.save(() => {
    console.log('saved')
})
*/