<?php

	include_once('inc/defs.inc.php');

	// where we are?
	if (isset($_GET['subtopic']))
		$subtopic = $_GET['subtopic'];
	else
		$subtopic = 'toc';

?>


<h2 class="section_title">Utenti</h2>

<?php include_once(USERS_DIR.$subtopic.'.inc.php'); ?>
