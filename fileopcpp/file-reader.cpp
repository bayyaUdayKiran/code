# include <iostream>
# include <fstream>
# include <string>

using namespace std;

void read_file_chars(string filename){
    ifstream file(filename);

    if(!file.is_open()){
        cerr << "Couldn't open file '" << filename << "' " << endl;
        return;
    }

    char ch;
    while(file.get(ch)){
        if(ch == EOF)
            break;
        cout << ch;
    }
    file.close();       
}

void read_file_buffer(string filename, int buff){
    ifstream file(filename);
    
    if(!file.is_open()){
        cerr << "Couldn't open file '" << filename << "' " << endl;
        return;
    }

    char buffer[buff];
    while(file.read(buffer, buff)){
        //Elimantes the EOF character copied into the buffer while reading the file..
        //buffer[MAX_BUFF] = '\0';
        //cout << buffer;
        for(int i = 0; i<buff; i++)
            cout << buffer[i];
    }
    file.close();
}

void read_file_lines(string filename){
    ifstream file(filename);

    if(!file.is_open()){
        cerr << "Couldn't open file '" << filename << "' " << endl;
        return;
    }
    string line;
    while(getline(file, line))
        cout << line << endl;
    
}




int main(){
    read_file_lines("test.txt");
    return 0;
}