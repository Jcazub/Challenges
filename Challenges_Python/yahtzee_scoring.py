

def yahtzee_upper(rolls):

    index = len(rolls) - 1
    max_count = rolls[index]
    current_count = rolls[index]

    while index > 0:

        if rolls[index] == rolls[index - 1]:
            current_count += rolls[index - 1]
        else:
            current_count = rolls[index - 1]

        max_count = max(max_count, current_count)
        index -= 1

    print(max_count)


rolls1 = [2, 3, 5, 5, 6]
yahtzee_upper(rolls1)
