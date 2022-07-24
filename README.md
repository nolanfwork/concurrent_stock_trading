# concurrent_stock_trading
A simple project using concurrent programming to demo stock trading.
Deployment Requirement:
1. Import root folder into Java IDE;
2. Be sure to have Gson ready (provided in root/libs folder) since trading target company reading is from .json file (as the one provided in root folder);
3. Please provide your own .json file and .csv file for the following reasons:
    a. .json file is used to present which companies are avaliable, how many brokers are avaliable for each company, for stock trading;
    b. .csv file is used to schedule when to trade stocks for which company;
4. Run PA3.jar to launch program

Functionality:
    This program reads each company presented from .json, along with their avaliable stock brokers. Then, it follows .csv file to begin trading; once a company's broker is ran out, it will hold until the first broker becomes avalibale again (the hold will not stop the whole program, it just works for the company's own trading only, while other companies' trading is still going if their brokers are not ran out). Each Line of .csv (each trading schedule) occupies one broker from the specified company.