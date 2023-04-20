#include <bits/stdc++.h>
using namespace std;
#include "../ecomm/Portal.h"
#include "DemoPortal.h"

vector<string>split(string s1) // Vector to Split reading from the file
{
    vector <string> v1;
    int l=0;
    for(int i=0;i<s1.length();i++)
    {
        if(s1[i]==' ')
        {
            v1.push_back(s1.substr(l,i-l));
            l = i + 1;
        }
    }
    v1.push_back(s1.substr(l,s1.length() - l));
    return(v1);
}
void printMatrix(vector<vector<string> > &products) //Print method to get answer
{
    for(int i=0;i<products.size();i++)
    {
        for(int j=0;j<products[i].size();j++)
        {
            cout<<products[i][j]<<" ";
        }
        cout<<endl;
    }
}

bool sortPrice(const vector<string>& v1, const vector<string>& v2)
{
    return stof(v1[4]) < stof(v2[4]);
}


bool sortName(const vector<string>& v1, const vector<string>& v2) // Sorts name accordingly
{
    return v1[2] < v2[2];
}

DemoPortal::DemoPortal(string portalID,int requestID) // Demo Portal Id to establish ID
{
    this->requestID=requestID;
    this->portalID=portalID;
}

void DemoPortal::processUserCommand(string command) //processes user command
{
    fstream f; // File handling
    //cout<<command<<endl;
    f.open("PortalToPlatform.txt", ios::app);// opens portalToplatform.txt
    vector<string> split_str = split(command);
    // for(int i=0;i<split_str.size();i++)
    // {
    //     cout<<split_str[i]<<endl;
    // }
    requestID++;
    mapping[requestID]=split_str;
    if(split_str[0]=="List")
    {
    
        f<<this->portalID<<" "<<this->requestID <<" "<<"List"<<" "<<split_str[1]<<" "<<split_str[2]<<"\n";
    }
    else if(split_str[0]=="Buy")
    {
        f<<this->portalID<<" "<<this->requestID<<" "<<"Buy"<<" "<<split_str[1]<<" "<<split_str[2]<<"\n";
    }
    else if(split_str[0]=="Start")
    {
        f<<this->portalID<<" "<<this->requestID<<" "<<"Start"<<endl;
    }
    else
    {
        requestID--;
        this->checkResponse();
    }
    f.close();
}

void DemoPortal::checkResponse() // Check Response 
{
    string text;
    ifstream MyReadFile("PlatformToPortal.txt"); // File reading
    vector<vector<string> >products;
    while(getline(MyReadFile, text))
    {
        vector<string> response = split(text);
        // for(int i=0;i<response.size();i++)
        // {
        //     cout<<response[i]<<endl;
        // }
        // cout<<text<<endl;
        //response[1] is the requestID
        //mapping[stoi(response[1])][0] will be the type of request
        if(processedResponses.find(stoi(response[1]))==processedResponses.end() && this->portalID==(response[0]))
        {
            // cout<<mapping[stoi(response[1])][0]<<endl;
            if(mapping[stoi(response[1])][0]!="List")
            {
                // cout<<"product size is "<<products.size()<<endl;
                if(products.size()!=0)
                {
                    //products[0][1] is RequestID
                    if(mapping[stoi(products[0][1])][2]=="Name")
                    {
                        sort(products.begin(), products.end(), sortName);
                    }
                    else if(mapping[stoi(products[0][1])][2]=="Price")
                    {
                        sort(products.begin(), products.end(), sortPrice);       
                    }
                    printMatrix(products);
                    products.clear();
                }
                cout<<text<<endl;
            }
            else
            {
                if(products.size()==0)
                {
                    products.push_back(response);
                }
                else
                {
                    // cout<<response[1]<<" "<<products[0][1]<<endl;
                    if(stoi(response[1])==stoi(products[0][1]))//checks if the previous products requestID
                    //matches with the current products requestID
                    {
                        // cout<<"here2"<<endl;
                        products.push_back(response);//same requestID elements should be added only 
                    }
                    else
                    {
                        if(mapping[stoi(products[0][1])][2]=="Name")
                        {
                            sort(products.begin(), products.end(), sortName);
                        }
                        else if(mapping[stoi(products[0][1])][2]=="Price")
                        {
                            sort(products.begin(), products.end(), sortPrice);       
                        }
                        printMatrix(products);
                        products.clear();
                        products.push_back(response);
                    }
                }
                
            }
        }
    }
    if(products.size()!=0)
    {
        //products[0][1] is RequestID
        if(mapping[stoi(products[0][1])][2]=="Name")
        {
            // cout<<"here1"<<endl;
            sort(products.begin(), products.end(), sortName);
        }
        else if(mapping[stoi(products[0][1])][2]=="Price")
        {
            sort(products.begin(), products.end(), sortPrice);       
        }
        printMatrix(products);
    }
    for(int i=1;i<=requestID;i++)
    {
        processedResponses[i]=true;
    }
    MyReadFile.close();
}