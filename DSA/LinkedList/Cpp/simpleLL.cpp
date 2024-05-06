# include <iostream>
# include <stdlib.h>

using namespace std;

struct Node{
    int data;
    Node *next;

    Node(int data){
        this->data = data;
        this->next = NULL;
    }
};
    
void printll(Node *head){
    if(head == NULL){
        cout << "Linked List is empty.." << endl;
        exit(-1);
    }

    Node *temp = head;
    while(temp != NULL){
        cout << temp->data << ' ';
        temp = temp->next;
    }
    cout << endl;
}

void printllr(Node *node){
    if(node == NULL){
        cout << endl;
        return;
    }
        

    cout << node->data << ' ';
    printllr(node->next);
}

int searchll(Node *head, int n){
    Node *temp = head;
    int k = 1;
    if(head == NULL){
        cout << "Linked List is empty.." << endl;
        exit(-1);
    }

    while(temp != NULL){
        if(temp->data == n)
            return k;

        temp = temp->next;
        k++;
    }

    return -1;
}

int searchllr(Node *head, int n){
    if(head == NULL)
        return -1;
    

    if(head->data == n)
        return 1;
    else{
        int r = searchllr(head->next, n);
        if(r == -1)
            return -1;
        else
            return (r+1); 
    }
}

int jumps(Node* head){
    Node * temp = head;
    int count = 0;
    while(temp->next != NULL){
        count++;
        temp = temp->next;
    }
    return count;
}

Node* mid_node(Node* head){
    Node *temp = head;
    int k = jumps(head);
    for(int i = k; i>(k/2); i--)
        temp = temp->next;
    
    return temp;
}


int main(){
    Node *head = new Node(10);
    Node *n1 = new Node(15);
    Node *n2 = new Node(65);
    Node *n3 = new Node(12356);
    Node *n4 = new Node(2);
    Node *n5 = new Node(7);
    head->next = n1;
    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = n5;

    //cout << num_of_jumps(head);
    cout << mid_node(head)->data << endl;

    
}



