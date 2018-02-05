const list = (req, res) => {
    const numeros = []
    for(let x = 1; x <= 100; x++){
        numeros.push(x)
    }
    res.render('tabuada/list', { numeros })
}

const tabuada = (req, res) => {
    const tabuadas = []
    const num = req.params.num

    for(let i = 0; i <= 100; i++) {
        tabuadas.push({
            num,
            i,
            resultado: (num*i)
        })
    }
    res.render('tabuada/tabuada', {
        num: req.params.num,
        tabuadas
    })
}

module.exports = {
    list,
    tabuada
}