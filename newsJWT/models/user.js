//BD Properties
const mongoose = require('mongoose')

//Schema Definition
const UserSchema = new mongoose.Schema({
    username: {
        type: String,
    },
    password: {
        type: String,
    },
    facebookId: String,
    googleId: String,
    name: String,
    roles: {
        type: [String],
        enum: ['admin', 'user'],
    }
})

const bcrypt = require('bcrypt')

UserSchema.pre('save', function(next) { 
    const user = this

    if(!user.isModified('password')) {
        return next() 
    }

    bcrypt.genSalt((err, salt) =>{
        //   console.log(salt) 
          // bcrypt.hash('abc123', salt, (err, hash) => {  
          bcrypt.hash(user.password, salt, (err, hash) => {  
               //console.log(hash)
               user.password = hash
               next()
           })
       })
})

UserSchema.methods.checkPassword = function(password) { 
    return new Promise((resolve, reject) => {
        bcrypt.compare(password, this.password,(err, isMatch) => {
            if(err){
                reject(err)
            }
            else{
                resolve(isMatch)
            }
        }) 
    })
}

//Creating collection Users with its schema into MongoDB
const Users = mongoose.model('Users', UserSchema)

module.exports = Users