#include <bits/stdc++.h>
#include "demo/DemoPortal.h"
using namespace std;
	int main()
	{
		//int arg,char** argv
		//char c=*argv[1];
		//string sq(1,c);
		DemoPortal *obj=new DemoPortal("2",100);//portal id and request id initially
		while(true)
		{
			string s;//taking string input
			getline(cin,s);
			obj->processUserCommand(s);//going method processusercommand through object of demoportal
		}
		// TODO Auto-generated method stub
	}

