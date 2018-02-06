const mysql = require('mysql')
const connection = mysql.createConnection({
    host: '127.0.0.1',
    user: 'root',
    password: '',
    database: 'cadastro'
})

const fs = require('fs')
const writtable = fs.createWriteStream('pessoas.csv')

writtable.write('id,nome\n', () => {
    connection.connect((err) => {
        if(err){
            console.log('Error to connect into database: ' + err)
        }
        else{
            const query = connection.query('select * from pessoas')
            query.on('result', (row) => {
                //console.log(row)
                connection.pause()
                
                const data = row.id + ',' + row.nome + '\n'
                writtable.write(data, () => {
                    connection.resume()
                    //console.log('dado salvo')
                })
    
               /* writtable.write(JSON.stringify(row), () => {
                    connection.resume()
                    console.log('dado salvo')
                })*/
            })
    
            query.on('end', () => {
                writtable.end()
                connection.end()
                console.log('CSV file created sucessfully!')
            })
        }
    })
})