#Revolut Project

#Scope

##How to run
```
./gradlew run
```

##APIs
```
GET > /accounts?showBalance=[true|false]
```
```
GET > /accounts/{suid}
```

```
POST > /operations/transfer
```
Body:
```
{
	"amount": 50,
	"source": {
		"number": "1968974456"
	},
	"destination": {
		"number": "2654987415"
	}
}
```

##Possible improvements
- Add transaction id in the header of the transactions for a better troubleshooting
- Validate transaction using destination's suid and name
- Use a temporary structure to improve balance calculation (such as a database view, recording the balance of the account at the end of previous month)
- Test the other APIs that weren't part of the scope