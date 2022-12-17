# Assignments : A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

Input and out as Json objects

used Spring boot, maven,java 8 Lamda ,custom Http headers, Eception handler , Junit 5 jupitor

Input 

{
       "custRewardList":[
                                   {
                    "id":2,
                    "name":"Ishan",
                    "purchase_amount":60,
                    "purchase_date":"01-09-2020"
                 },
                  {
                    "id":2,
                    "name":"Ishan",
                    "purchase_amount":80.5,
                    "purchase_date":"22-10-2020"
                 },
                  {
                    "id":1,
                    "name":"Anu",
                    "purchase_amount":100.5,
                    "purchase_date":"13-11-2020"
                 }
    	] 
  }
  
  
  output
  
  {
    "customerRewardDetailsList": [
        {
            "id": 1,
            "name": "Anu",
            "total_reward": 51,
            "month_reward": {
                "Jan": 51
            }
        },
        {
            "id": 2,
            "name": "Ishan",
            "total_reward": 40.5,
            "month_reward": {
                "Oct": 30.5,
                "Jan": 10
            }
        }
    ]
}
