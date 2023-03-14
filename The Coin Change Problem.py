def getWays(n, c):

    ways={coin:[0 for amount in range(n+1)] for coin in c}

    previousCoin = None
    for coin in c:
        
        for amount in range(n + 1):
            # print(f"coin({coin}) & amount({amount}):")

            if previousCoin is None:
                ways[coin][amount] = 1 if (amount % coin == 0) else 0
                # print('\n'.join(f"{k}: {v}" for k,v in ways.items()) + '\n')
                continue

            if coin > amount:
                ways[coin][amount] = ways[previousCoin][amount]
            else:
                ways[coin][amount] = (ways[previousCoin][amount]
                                      + ways[coin][amount - coin])
            # print('\n'.join(f"{k}: {v}" for k,v in ways.items()) + '\n')
                                      
        previousCoin = coin

    return ways[previousCoin][n]