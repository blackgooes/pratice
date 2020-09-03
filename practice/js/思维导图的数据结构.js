class SocietyMap {
  name;
  children = [];

  constructor(name) {
    this.name = name;
  }

  isMap() {
    return this.name;
  }

  getValue() {
    const obj = {};

    obj[this.name] = this.children.map((item) => item.getValue());

    return obj;
  }

  pushed(map, level) {
    if (!map.isMap()) return;
    if (level == 0) {
      this.children.push(map);
    } else {
      this.children[this.children.length - 1].pushed(map, level - 1);
    }
  }
}

function str2json(str) {
  const array = str.split("\n").map((item) => item.split(","));

  const topMap = new SocietyMap("top");

  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array[i].length; j++) {
      const map = new SocietyMap(array[i][j]);
      topMap.pushed(map, j);
    }
  }
  return topMap.children[0].getValue();
}

const str = `奴隶社会,非洲,古埃及文明,金字塔
,亚洲,两河流域文明,汉谟拉比法典
,,古印度,种姓制度
,,,佛教的创立
,欧洲,希腊,希腊城邦
,,,雅典民主
,,罗马,城邦
,,,帝国的征服与扩展
,,希腊罗马古典文化,建筑艺术
,,,公历`;

const obj = str2json(str);
console.log(JSON.stringify(obj));