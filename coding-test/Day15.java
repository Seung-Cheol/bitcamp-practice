
public class Day15 {

//LinkedList 구현체
public static class LinkedList2 {

  private Node first;
  private Node last;
  private int size;

  public void add(Object value) {
    Node node = new Node();
    node.value = value;
    if (last == null) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }
    size++;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    int cursor = 0;
    while (cursor < size) {
      arr[cursor++] = first.value;
      first = first.next;
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("인덱스가 넘었다");
    }
    int cursor = 0;
    Node node = first;
    while (++cursor <= index) {
      node = node.next;
    }
    return node.value;
  }

  //해당 인덱스의 값을 변경
  public void set(int index, Object value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("인덱스가 넘었다");
    }

    int cursor = 0;
    Node node = first;
    while (++cursor <= index) {
      node = first.next;
    }
    node.value = value;
  }

  //해당 인덱스에 끼워넣기(추가)
  public void add(int index, Object value) {

    //덮어 씌우는게 아니라 추가 하는 경우이므로 인덱스와 사이즈가 같을 수 있으므로 > 부호 선택
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("인덱스가 넘었다");
    }

    Node node = new Node();
    node.value = value;

    if (last == null) {
      first = last = node;
      size++;
      return;
    }
    if (index == 0) {
      node.next = first;
      first = node;
      size++;
      return;
    }

    if (size == index) {
      last.next = node;
      last = node;
      size++;
      return;
    }

    int cursor = 0;
    Node currNode = first;
    while (++cursor < index) {
      //currnode를 index 바로 전까지 저장함 0,1,2,3이 있으면 3에 저장하기 위해서 2에서 3의 정보를 저장해야함
      currNode = currNode.next;
    }
    //추가할 node에 다음번쨰 주소를 우선 저장함
    node.next = currNode.next;
    //현재 노드의 주소를 이전 노드에 덮어씌움
    currNode.next = node;
    size++;
  }

  public void remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    if (size == 1) {
      first = last = null;
      return;
    }

    if (index == 0) {
      first = first.next;
      size--;
      return;
    }

    int cursor = 0;
    Node currNode = first;
    while (++cursor < index) {
      currNode = currNode.next;
    }
    currNode.next = currNode.next.next;
    if (index == (size - 1)) {
      last = currNode;
    }
    size--;
  }

  public boolean remove(Object value) {
    Node prevNode = null;
    Node node = null;
    Node cursor = first;
    for (int i = 0; i < size; i++) {
      if (cursor.value.equals(value)) {
        node = cursor;
        break;
      }
      prevNode = cursor;
      cursor = cursor.next;
    }
    if (node == null) {
      return false;
    }

    if (node == first) {
      first = first.next;
      if (first == null) {
        last = null;
      }
    } else {
      prevNode.next = node.next;
    }
    size--;
    return true;
  }

  private static class Node {

    Object value;
    Node next;
  }
}

}
