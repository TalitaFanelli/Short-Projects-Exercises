//Router Properties
const express = require('express')
const router = express.Router()

//Passport 
const passport = require('passport')
const LocalStrategy = require('passport-local').Strategy
const FacebookStrategy = require('passport-facebook').Strategy
const GoogleStrategy = require('passport-google-oauth').OAuth2Strategy
const jwt = require('jsonwebtoken')
const jwtSecret = 'talita-news'

passport.serializeUser((user, done) => {
    done(null, user)
})

passport.deserializeUser((user, done) => {
    done(null, user)
})

router.use(passport.initialize())
router.use(passport.session())

passport.use(new LocalStrategy(async (username, password, done) => {
    const user = await User.findOne({ username })

    if (user) {
        const isValid = await user.checkPassword(password)

        if (isValid) {
            return done(null, user)
        }

        else {
            return done(null, false)
        }
    }
    else {
        return done(null, false)
    }
}))

passport.use(new FacebookStrategy({
    clientID: '789480194586913',  
    clientSecret: 'e1b2fdcc9df5d557da26a7d7c244b128', 
    callbackURL: 'http://localhost:3000/facebook/callback',  
    profileFields: ['id', 'displayName', 'email', 'photos']
}, async (accessToken, refreshToken, profile, done) => { 
    const userDB = await User.findOne({ facebookId: profile.id })  

    if (!userDB) {
        const user = new User({
            name: profile.displayName,
            facebookId: profile.id,
            roles: ['user']
        })

        await user.save()
        done(null, user)
    }
    else {
        done(null, userDB)
    }
}))

passport.use(new GoogleStrategy({
    clientID: '940170674154-to6k5corgfrcta8jcqknlajq2c1hvovt.apps.googleusercontent.com',
    //https://console.developers.google.com 
    clientSecret: 'FFSWgSKWo4EWp95emjF-aepP',  
    callbackURL: 'http://localhost:3000/google/callback', 
}, async (accessToken, refreshToken, err, profile, done) => {
    const userDB = await User.findOne({ googleId: profile.id })  

    if (!userDB) {
        const user = new User({
            name: profile.displayName,
            googleId: profile.id,
            roles: ['user']
        })

        await user.save()
        done(null, user)
    }
    else {
        done(null, userDB)
    }
}))

//Importing Models
const User = require('../models/user')

router.use((req, res, next) => {
    if (req.isAuthenticated()) {
        res.locals.user = req.user
        if (!req.session.roles) { 
            req.session.roles = req.user.roles[0]
        }
        res.locals.roles = req.session.roles
    }

    next()
})

router.get('/change-role/:role', (req, res) => {
    if (req.isAuthenticated()) {
        if (req.user.roles.indexOf(req.params.role) >= 0) {
            req.session.roles = req.params.role
        }

        res.redirect('/')
    } else {
        res.redirect('/login')
    }
})

//Render Login Page
router.get('/login', (req, res) => {
    res.render('login')
})

router.get('/logout', (req, res) => {

    req.session.destroy(() => {
        res.redirect('/')
    })
})

/*Validate user's credentials
router.post('/login', async (req, res) => {
    const user = await User.findOne({
        username: req.body.username
    })

    if (user) {
        const isValid = await user.checkPassword(req.body.password)

        if (isValid) {
            req.session.user = user
            req.session.roles = user.roles[0]
            res.redirect('/')
        } else {
            res.redirect('/login')
        }
        //res.send({user, isValid})
    } else {
        res.redirect('/login')
    }
})*/

//Validate user's credentials with local
router.post('/login', passport.authenticate('local', {
    successRedirect: '/',
    failureRedirect: '/login',
    failureFlash: false
}))

//Validate user's credentials with fb
router.get('/facebook', passport.authenticate('facebook'))
router.get('/facebook/callback',  
    passport.authenticate('facebook', { failureRedirect: '/' }),
    (req, res) => {//usuário logou com sucesso
        res.redirect('/')
    })


//Validate user's credentials with google
router.get('/google', passport.authenticate('google', { scope: ['https://www.googleapis.com/auth/userinfo.profile'] }))
router.get('/google/callback',  
    passport.authenticate('google', { failureRedirect: '/', successRedirect: '/' }))

router.get('/get-user', async (req, res) => {
    const token = req.headers['x-access-token'] || req.body.token || req.query.token
    if (token) {
        try{
        const decoded = jwt.verify(token, jwtSecret)
        //res.send(token)
        //res.send(decoded)
        const user = await User.findOne({_id: decoded.id})
        res.send(user)
        }
        catch(e){
            res.send({success: false})
        }
    }
    else{
        res.send({success: false})
    }
})

router.post('/jwt', async (req, res) => {
    const { username, password } = req.body

    const user = await User.findOne({ username })

    if (user) {
        const isValid = await user.checkPassword(password)

        if (isValid) {
            const userToken = {
                id: user._id,
                username: user.username,
                roles: user.roles
            }

            jwt.sign(userToken, jwtSecret, (err, token) => { 
                //console.log(err, token)
                res.json({ success: true, token })
            })
        }
        else {
            res.json({ success: false })
        }
    }
    else {
        res.json({ success: false })
    }
})

module.exports = router
