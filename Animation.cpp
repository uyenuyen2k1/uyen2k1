#include "Animation.h"

void Animation::setFeild()
{
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 10; j++) {
			feild[i][j] = 0;
		}
	}
}

void Animation::setFigures()
{
	/*
	0 1
	2 3
	4 5
	6 7
	*/
	int figures[7][4] = 
	{
		1,3,5,7, //I
		2,4,5,7, //Z
		3,5,4,6, //S
		3,5,4,7, //T
		2,3,5,7, //L
		3,5,7,6, //J
		2,3,4,5 //O
	};
}

bool Animation::check()
{
	for (int i = 0; i < 4; i++) {
		if (a[i].first < 0 || a[i].first >= 10 || a[i].second >= 20) return 0;
		else if (feild[a[i].second][a[i].first]) return 0;
	}
	return 1;
}

void Animation::setMove(int dx, bool test)
{
	for (int i = 0; i < 4; i++) {
		b[i] = a[i];
		a[i].first += dx;
	}
	if (!test) for (int i = 0; i < 4; i++) a[i] = b[i];
}

void Animation::setRotate(bool rotate,bool test)
{
	pair <int, int> p;
	p = a[1]; // the centre of rotation
	for (int i = 0; i < 4; i++) {
		int x = a[i].second - p.second;
		int y = a[i].first - p.first;
		a[i].first = p.first - x;
		a[i].second = p.second + y;
	}
	if (!test) for (int i = 0; i < 4; i++) a[i] = b[i];

}
