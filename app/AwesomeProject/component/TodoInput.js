import { Button, TextInput, View, StyleSheet } from "react-native";
import { useState } from "react";

export default function TodoInput(props) {
	const [todoInput, setTodoInput] = useState('')

    function handleTodoInput(value) {
      setTodoInput(value)
    }

    function sendTodo() {
      props.handleTodos(todoInput)
      setTodoInput('')
    }

  return(
    <View style={styles.container}>
            <TextInput value={todoInput} style={styles.textInput} placeholder="Enter the todo" onChangeText={handleTodoInput}/>
            <Button title="Add todo" onPress={sendTodo}/>
      </View>
  )
}

const styles = StyleSheet.create({
	container: {
		marginTop: 40,
    flexDirection: 'row',
		justifyContent: "center",
		borderWidth: 1,
    borderColor:'red',	
    flex:1,
    alignItems:'center',
	}, 
	textInput: {
		borderWidth: 1,
		borderColor: 'dodgerblue',
		width: '50%',
		marginRight: 8,
		borderRadius: 6,
		padding: 6
	}
})