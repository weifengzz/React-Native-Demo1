/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */
'use strict';

var React = require('react-native');

var ALAppView = require('./ALAppView');
console.log(ALAppView);

ALAppView.show('大家好我叫宋熙明', ToastAndroid.SHORT, () => {
  require("react-native").ToastAndroid.show("Hello", "world");
});

var {
  AppRegistry,
  StyleSheet,
  Text,
  View,
} = React;

var MyProject = React.createClass({
  render: function() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          大家好我叫宋熙明!
        </Text>
        <Text style={styles.instructions}>
          时间不在于你拥有多少，而在于你怎样把握！
        </Text>
      </View>
    );
  }
});



var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

var MOCKED_MOVIES_DATA = [
{title:'=Title',year:'2015',posters:{thumbnail:'http://i.imgur.com/UePbdph.jpg'},
}];

var {
  AppRegistry,Image,StyleSheet,Text,View,
}= React;


AppRegistry.registerComponent('MyProject', () => MyProject);
