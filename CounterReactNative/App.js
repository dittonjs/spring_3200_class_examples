import React, { useState } from 'react';
import { View, Text, Button, StyleSheet } from 'react-native';
export default () => {
  const values = useState(0);
  const [count, setCount] = useState(0);

  const increment = () => setCount(count + 1);
  const decrement = () => setCount(count - 1);

  return (
    <View style={styles.container}>
      <Text style={styles.text}>{count}</Text>
      <Button title="Increment" onPress={increment}/>
      <Button title="Decrement" onPress={decrement}/>
    </View>
  );
}


const styles = StyleSheet.create({
  container: { flex: 1, alignItems: 'center'},
  text: {fontSize: 100}
})