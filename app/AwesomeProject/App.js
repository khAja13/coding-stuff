import { useState } from 'react';
import {
  Button,
  StyleSheet,
  Text,
  TextInput,
  View,
  ScrollView,
  FlatList,
} from 'react-native';
import TodoItem from './component/TodoItem';
import TodoInput from './component/TodoInput';

export default function App() {
  const [todos, setTodos] = useState([]);

  function handleTodos(todoInput) {
    setTodos((current) => [
      ...current,
      { text: todoInput, id: Math.random().toString() },
    ]);
  }

  function deleteTodo(deleteId) {
    setTodos((todo) => {
      return todo.filter((t) => t.id !== deleteId);
    });
  }
  return (
    <View style={{ flex: 1, backgroundColor: '#ffffff'}}>
      <TodoInput handleTodos={handleTodos} />
      <View style={{ flex: 5 }}>
        <View style={styles.listTodos}>
          <Text style={{ fontSize: 18 }}>List of todo's</Text>
        </View>
        <FlatList
          data={todos}
          renderItem={(todo) => (
            <TodoItem
              item={todo.item.text}
              id={todo.item.id}
              deleteTodo={deleteTodo}
            />
          )}
          keyExtractor={(item, index) => {
            return item.id;
          }}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  listTodos: {
    paddingVertical: 25,
    borderBottomWidth: 1,
    borderColor: 'green',
    alignItems: 'center',
  },
});
