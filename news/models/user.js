//BD Properties
const mongoose = require('mongoose')

//Schema Definition
const UserSchema = new mongoose.Schema({
    username: {
        type: String,
        required: true
    },
    password: {
        type: String,
        required: true
    },
    roles: {
        type: [String],
        enum: ['admin', 'user'],
        required: true
    }
})

const bcrypt = require('bcrypt')

UserSchema.pre('save', function(next) {
    const user = this

    if(!user.isModified('password')) {
        return next() 
    }

    bcrypt.genSalt((err, salt) =>{
          bcrypt.hash(user.password, salt, (err, hash) => { //password + salt = hash
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