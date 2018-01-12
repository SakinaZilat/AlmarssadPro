path = require('path');
const webpack = require('webpack');
module.exports = {
//   devtool: 'cheap-module-source-map',
  entry: [
    './src/index.js'
  ],
  output: {
  //  path: path.join(__dirname, 'dist'),
    path: path.join(__dirname, '../../../src/main/resources/static'),

    publicPath: '/',
   filename: 'bundle.js'
  },
  module: {
    loaders: [{
      exclude: /node_modules/,
      loader: 'babel',
      query: {
        presets: ['react', 'es2015', 'stage-1']
      }
    }]
  },
  resolve: {
    extensions: ['', '.js', '.jsx']
  },
  devServer: {
    historyApiFallback: true,
    contentBase: './'
  },
  plugins: [
  new webpack.DefinePlugin({
    'process.env': {
      'NODE_ENV': JSON.stringify('development')
    }
  })
]
};
