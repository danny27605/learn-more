package com.cnipr.open.ms.test.pd.learn;

/**
 * 查找
 *
 * @author Bi Yunfei
 * @date 2019/8/6 14:19
 */
public class find {
	public static void main(String[] args) {
		Node node = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(32);
		Node node3 = new Node(14);
		Node node4 = new Node(52);
		Node node5 = new Node(6);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		findeLem(node, 3);

	}

	/**
	 * 找出单链表中的倒数第k个元素
	 * 此题我们可以先定义两个指针，p和q。让p和q都指向头结点。在定义一个i，i的初始值为0。然后进入一个for循环，直到p走到链表结尾，每次i++。
	 * 当i < k 的我们让p走，q不走。当i >= k 的时候我们让p和q同时走一步。当p走到结尾的时候，那么q走的值就是倒数k的位置，我们返回这个值就好了
	 */
	public static Node findeLem(Node node, int k) {
		if (k < 1) {
			return null;
		}
		Node n1 = node;
		Node n2 = node;
		for (int i = 0; i < k && n1 != null; i++) {
			n1 = n1.next;
		}
		if (n1 == null) {
			return null;
		}
		while (n1 != null) {
			n1 = n1.next;
			n2 = n2.next;
		}
		System.out.println(n2.num);
		return n2;
	}


	static Node head = null;

	/**
	 * 查找单链表的中间节点
	 */
	public static Node getMid(Node head) {
		Node p = head;
		Node q = p;
		while (p != null && p.next != null && p.next.next != null) {
			p = p.next.next;
			q = q.next;
		}
		return q;
	}

	/**
	 * 链表长度
	 */
	public int getLen(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	/**
	 * 增加节点
	 */
	public void add(int num) {
		Node n = new Node(num);
		if (head == null) {
			head = n;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = n;
	}

	/**
	 * 遍历链表
	 */
	public void traver(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.num + "\t");
			temp = temp.next;
		}
	}

	/**
	 * 对链表进行排序
	 */
	public Node orderList(Node head) {
		int tmp;
		Node curNode = head;
		Node nextNode = curNode.next;
		while (curNode.next != null) {
			nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.num > nextNode.num) {
					tmp = curNode.num;
					curNode.num = nextNode.num;
					nextNode.num = tmp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}

	/**
	 * 递归遍历
	 */
	public void printDiGui(Node n) {
		if (n != null) {
			System.out.print(n.num + "\t");
			printDiGui(n.next);
		}
	}

	/**
	 * 删除重复节点
	 */
	public void deleteCopy(Node head) {
		Node cur = head;
		while (cur.next != null) {
			Node next = cur.next;
			if (cur.num == next.num) {
				cur.next = next.next;
				cur = cur.next;
			} else {
				cur = cur.next;
			}
		}
	}

	/**
	 * 删除节点
	 */
	public void delete(Node head, int index) {
		if (index < 1 || index > getLen(head)) {
			return;
		}
		//头结点，头指针有待完善
		if (index == 1) {
			head.next = head.next.next;
			return;
		}
		Node preNode = head;
		Node curNode = preNode.next;
		int count = 1;//count==2
		while (curNode != null) {
			if (index == count) {
				preNode.next = curNode.next;
				return;
			}
			preNode = curNode;
			curNode = curNode.next;
			count++;
		}

	}
}

//单链表
class Node {
	int num;
	Node next;

	public Node() {
	}

	public Node(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}