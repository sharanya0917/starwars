import random
import time

class Character:
    def __init__(self, name, health, attack_power):
        self.name = name
        self.health = health
        self.max_health = health
        self.attack_power = attack_power
        self.score = 0
    
    def take_damage(self, damage):
        self.health -= damage
        if self.health < 0:
            self.health = 0
    
    def heal(self, amount):
        self.health = min(self.health + amount, self.max_health)
    
    def attack(self, opponent):
        damage = random.randint(int(self.attack_power * 0.8), int(self.attack_power * 1.2))
        opponent.take_damage(damage)
        return damage
    
    def is_alive(self):
        return self.health > 0

class Enemy:
    def __init__(self, name, health, attack_power):
        self.name = name
        self.health = health
        self.max_health = health
        self.attack_power = attack_power
    
    def take_damage(self, damage):
        self.health -= damage
        if self.health < 0:
            self.health = 0
    
    def attack(self, opponent):
        damage = random.randint(int(self.attack_power * 0.7), int(self.attack_power * 1.1))
        opponent.take_damage(damage)
        return damage
    
    def is_alive(self):
        return self.health > 0

def display_status(player, enemy):
    print("\n" + "="*50)
    print(f"{player.name} HP: {player.health}/{player.max_health}")
    print(f"{enemy.name} HP: {enemy.health}/{enemy.max_health}")
    print(f"Score: {player.score}")
    print("="*50)

def battle(player, enemy):
    print(f"\n*** Battle Start: {player.name} vs {enemy.name} ***")
    display_status(player, enemy)
    
    while player.is_alive() and enemy.is_alive():
        print("\nYour Turn:")
        print("1. Attack")
        print("2. Heal")
        print("3. Defend")
        
        choice = input("Choose action (1-3): ").strip()
        
        if choice == "1":
            damage = player.attack(enemy)
            print(f"{player.name} attacks {enemy.name} for {damage} damage!")
        elif choice == "2":
            heal_amount = 20
            player.heal(heal_amount)
            print(f"{player.name} healed for {heal_amount} HP")
        elif choice == "3":
            print(f"{player.name} takes a defensive stance!")
        else:
            print("Invalid choice! Attack instead.")
            damage = player.attack(enemy)
            print(f"{player.name} attacks {enemy.name} for {damage} damage!")
        
        if enemy.is_alive():
            enemy_damage = enemy.attack(player)
            print(f"\n{enemy.name} attacks {player.name} for {enemy_damage} damage!")
        
        display_status(player, enemy)
        time.sleep(1)
    
    if player.is_alive():
        print(f"\n*** Victory! {player.name} defeated {enemy.name}! ***")
        player.score += 100
        return True
    else:
        print(f"\n*** Defeat! {player.name} was defeated by {enemy.name}! ***")
        return False

def create_enemies():
    enemies = [
        Enemy("Stormtrooper", 30, 8),
        Enemy("Tusken Raider", 40, 10),
        Enemy("Darth Vader", 80, 15),
        Enemy("Imperial Guard", 50, 12),
        Enemy("Bounty Hunter", 45, 11)
    ]
    return enemies

def main():
    print("\n" + "*"*50)
    print("     Welcome to Star Wars Battle Game!")
    print("*"*50)
    
    print("\nChoose your character:")
    print("1. Luke Skywalker (HP: 100, Attack: 12)")
    print("2. Han Solo (HP: 80, Attack: 14)")
    print("3. Princess Leia (HP: 70, Attack: 13)")
    print("4. Yoda (HP: 60, Attack: 16)")
    
    choice = input("\nSelect character (1-4): ").strip()
    
    characters = {
        "1": Character("Luke Skywalker", 100, 12),
        "2": Character("Han Solo", 80, 14),
        "3": Character("Princess Leia", 70, 13),
        "4": Character("Yoda", 60, 16)
    }
    
    player = characters.get(choice, characters["1"])
    print(f"\nYou selected {player.name}!")
    
    enemies = create_enemies()
    random.shuffle(enemies)
    
    for enemy in enemies:
        if not battle(player, enemy):
            print(f"\nGame Over! Final Score: {player.score}")
            break
    else:
        print(f"\n*** You defeated all enemies! Final Score: {player.score} ***")
    
    print("\nThanks for playing Star Wars Battle Game!")

if __name__ == "__main__":
    main()
