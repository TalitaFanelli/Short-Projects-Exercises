const findAll = (connection) => {

    return new Promise((resolve, reject) => {
        connection.query('select * from people', (err, results) => {

            if (err) {
                reject(err)
            } else {
                resolve(results)
            }
        })
    })
}

const findById = (connection, id) => {

    return new Promise((resolve, reject) => {
        connection.query('select * from people where id = ' + id, (err, results) => {

            if (err) {
                reject(err)
            } else {
                if(results.length > 0){
                    resolve(results[0])
                }

                else{
                    resolve({})
                }
            }
        })
    })
}

const deletePerson = (connection, id) => {

    return new Promise((resolve, reject) => {
        connection.query('delete from people where id = ' + id + ' limit 1', (err) => {
            if(err){
                reject(err)
            }
            else{
                resolve()
            }
        })
    })
}

const createPerson = (connection, data) => {
    return new Promise((resolve, reject) => {
        connection.query(`insert into people (name, birthday, job) values('${data.name}', '${data.birthday}', '${data.job}')`, (err) => {
            
            if (err) {
                reject(err)
            } else {
                resolve()
            }
        })
    })
}

const updatePerson = (connection, id, data) => {
    return new Promise((resolve, reject) => {
        connection.query(`update people set name = '${data.name}', birthday = '${data.birthday}', job = '${data.job}' where id = '${id}'`, (err) => {
            
            if (err) {
                reject(err)
            } else {
                resolve()
            }
        })
    })
}

module.exports = {
    findAll,
    findById,
    deletePerson,
    createPerson,
    updatePerson
}