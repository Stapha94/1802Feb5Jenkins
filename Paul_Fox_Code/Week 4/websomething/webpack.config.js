const path = require('path');

module.exports = {

    entry: './compiled/index.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'dist')
    },
    watch: true,
    watchOptions: {

        aggregateTimeout: 300,
        poll: 500,
        ignored: /node_modules/

    }

}