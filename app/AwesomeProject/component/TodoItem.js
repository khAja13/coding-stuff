import { StyleSheet, View, Text, Pressable } from "react-native"

export default function TodoItem(props) {
    return(
      <Pressable onPress={props.deleteTodo.bind(this, props.id)}>
        <View style={styles.todoList}> 
            <Text>{props.item}</Text>
        </View>
        </Pressable>
    )
}

const styles = StyleSheet.create({
	todoList: {
		borderWidth: 1,
		borderColor: 'black',
		marginVertical: 5,
		marginHorizontal: 16,
		padding: 8,
		borderRadius: 6,
	}
})