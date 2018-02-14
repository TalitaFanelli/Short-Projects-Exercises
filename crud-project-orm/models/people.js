const createTablePeople = (sequelize, DataTypes) => {
    const People = sequelize.define('People', {
        name: DataTypes.STRING,
        birthday: DataTypes.STRING,
        job: DataTypes.STRING
    })
    return People
}

module.exports = createTablePeople