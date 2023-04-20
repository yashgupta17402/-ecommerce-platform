#include <bits/stdc++.h>
using namespace std;
#include"../ecomm/Portal.h"
#ifndef DEMO_PORTAL_H
#define DEMO_PORTAL_H
class DemoPortal:public Portal
{
    private:
    int requestID;
    string portalID;
    map<int,vector<string>> mapping;// maps requestID and request string
    unordered_map<int,bool> processedResponses;//maps the requestID and whether it is processed

    public:
    DemoPortal(string portalID,int requestID);
    void processUserCommand(string command);
    // checks for pending responses (in PortalToPlatform)
    // Displays response
    void checkResponse();
   
}; 
#endif
