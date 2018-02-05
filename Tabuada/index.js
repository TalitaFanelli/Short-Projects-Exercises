const express = require('express')
const path = require('path')
const app = express()
const port = process.env.PORT || 3000 

//Controller imports
const indexRouter = require('./routes/index')
app.use('/', indexRouter)

const tabuadaRouter = require('./routes/tabuada')
app.use('/tabuadas', tabuadaRouter)

//static path public
app.use(express.static('public'))

//view engine
app.set('views', path.join(__dirname, 'views'))
app.set('view engine', 'ejs')

app.listen(port, () => {
    console.log('listening port ' + port)
})