#pragma once
#include <SFML/Graphics.hpp>
#include <iostream>
using namespace sf;
using namespace std;
class Animation : public Sprite {
private:
	int feild[20][10] = { 0 };
	int figures[7][4];
	pair <int, int> a[4],b[4];
public:
	void setFeild();
	void setFigures();
	bool check();
	void setMove(int dx, bool test);
	void setRotate(bool rotate,bool test);

};
