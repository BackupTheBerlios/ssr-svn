<?php

	include_once('inc/defs.inc.php');

	// where we are?
	if (isset($_GET['browse']))
		$topic = $_GET['browse'];
	else
		$topic = 'welcome';

?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>SongShuffler:/home<?php echo '/'.$topic; ?></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="ssr.css" />
</head>

<body>
	<!-- top -->
	<div id="top">
		<a href="http://developer.berlios.de" title="BerliOS Developer">
			<img id="berlios" src="http://developer.berlios.de/bslogo.php?group_id=6590" alt="BerliOS Developer Logo" />
		</a>
		<h1 id="title">SongShuffler</h1>
	</div>
	<!-- /top -->


	<!-- body -->
	<div id="body">
	
		<?php include_once(CONTENTS_DIR.$topic.'.inc.php'); ?>
		
		<!-- footnotes -->
  		<div id="footnotes">
	   	<!-- validatori -->
	   	<div id="validators">
   			<a href="http://validator.w3.org/check?uri=referer">xhtml</a> ~ <a href="http://jigsaw.w3.org/css-validator/check/referer">css</a>
   		</div>
	   	<!-- /validatori -->  		
  		
			<div id="license">
				I contenuti di questo sito sono rilasciati sotto la <a href="http://www.gnu.org/licenses/fdl.txt">Gnu Free Documentation License</a>
		</div>
			<div id="mail">
				Mail: "rjack <i>at</i> users <i>dot</i> berlios <i>dot</i> de"
			</div>  
   	</div>
   	<!-- /footnotes -->	
	</div>
	<!-- /body -->


	<!-- main menu -->
	<div id="main_menu">
		<ul>
			<li><a href="index.php">home</a></li>
			<li><a href="index.php?browse=code">codice</a></li>
			<li><a href="index.php?browse=users">utenti</a></li>
			<li><a href="index.php?browse=developers">sviluppatori</a></li>
			<!-- <li><a href="index.php?browse=misc">miscellanea</a></li> -->
			<li><a href="wiki/">wiki</a></li>
		</ul>
	</div>
	<!-- /main menu -->
	
	<!-- news -->
	<div id="news">
		<h3>New</h3>
		<p class="even">10 maggio 2006<br />
			Aggiunto il <a href="wiki/">wiki</a>.
		</p>
		<p class="odd">6 maggio 2006<br />
			Prima versione del sito.
		</p>	
	</div>
	<!-- /news -->


</body>

</html>