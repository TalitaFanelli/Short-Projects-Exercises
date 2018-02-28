//Render Index Page
const index = (req, res) => {
    res.render('index')
}

//Render About page
const about = (req, res) => {
    res.render('about')
}

module.exports = {
    index,
    about
}