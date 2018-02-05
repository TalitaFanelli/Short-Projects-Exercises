const tabuadaController = require('./tabuada.js')
const sinon = require('sinon')

describe('tabuada controller', () => {
    it('Lists numbers from 1 to 100', () =>{

        const numeros = []
        for(let x = 1; x <= 100; x++){
            numeros.push(x)
        }

        let res = {
            render: function(){}
        }

        let mock = sinon.mock(res)

        mock.expects('render').once().withArgs('tabuada/list', {numeros})

        tabuadaController.list({}, res)
    })

    it('Multiplies numbers', () => {

        const tabuadas = []
        const num = 10
    
        for(let i = 0; i <= 100; i++) {
            tabuadas.push({
                num,
                i,
                resultado: (num*i)
            })
        }

        let res = {
            render: function(){}
        }

        let mock = sinon.mock(res)

        mock.expects('render').once().withArgs('tabuada/tabuada', {num, tabuadas})

        tabuadaController.tabuada({params: {num} }, res)
    })
})