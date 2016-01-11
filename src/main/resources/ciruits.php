<?php
$gates = $wires = [];
$handle = fopen('seven.txt', 'r');
while (($line = fgets($handle)) !== false) {
    preg_match("|(.*) -> (.*)|", $line, $matches);
    $wires[$matches[2]] = null;
    $gates[$matches[2]] = $matches[1];
}

function wire($w) {
    global $wires;

    if ($wires[$w] === NULL)
        $wires[$w] = (int) gate($w);

    return $wires[$w];
}

function gate($w) {
    global $gates;

    if (is_numeric($gates[$w]))
        return $gates[$w];

    if (strpos($gates[$w], ' ') === false)
        return wire($gates[$w]);

    if (preg_match("#NOT ([\d\w]+)#", $gates[$w], $matches1))
        return is_numeric($matches1[1]) ? ~ ((int) $matches1[1]) & 65535 : ~ ((int) wire($matches1[1])) & 65535;

    if (preg_match("#([\d\w]+) (AND|OR|LSHIFT|RSHIFT) ([\d\w]+)#", $gates[$w], $matches3)) {
        $a = is_numeric($matches3[1]) ? $matches3[1] : wire($matches3[1]);
        $b = is_numeric($matches3[3]) ? $matches3[3] : wire($matches3[3]);
        switch ($matches3[2]) {
            case 'AND': return $a & $b & 65535;
            case 'OR':  return $a | $b & 65535;
            case 'LSHIFT': return $a << $b & 65535;
            case 'RSHIFT': return $a >> $b & 65535;
        }
    }
}

echo "Solution for 'a' : " . wire("a") . PHP_EOL;
